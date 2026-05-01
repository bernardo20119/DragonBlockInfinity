#!/usr/bin/env bash

# Concatena todos os arquivos do diretório src e os arquivos build.gradle e gradle.properties
# em um arquivo de texto de saída.
# Uso:
#   ./collect_sources_to_text.sh [diretório base] [arquivo de saída]
# Exemplo:
#   ./collect_sources_to_text.sh . arquivo.txt

set -euo pipefail

BASE_DIR=${1:-.}
OUTPUT_FILE=${2:-arquivo.txt}

rm -f "$OUTPUT_FILE"

echo "Gerando '$OUTPUT_FILE' a partir de '$BASE_DIR'..."

touch "$OUTPUT_FILE"

echo "=== ARQUIVOS build.gradle e gradle.properties ===" >> "$OUTPUT_FILE"
for file in build.gradle gradle.properties; do
    if [ -f "$BASE_DIR/$file" ]; then
        echo "\n--- $file ---" >> "$OUTPUT_FILE"
        cat "$BASE_DIR/$file" >> "$OUTPUT_FILE"
    else
        echo "\n--- $file não encontrado ---" >> "$OUTPUT_FILE"
    fi
done

echo "\n=== ARQUIVOS EM $BASE_DIR/src ===" >> "$OUTPUT_FILE"
find "$BASE_DIR/src" -type f | sort | while IFS= read -r file; do
    echo "\n--- ${file#$BASE_DIR/} ---" >> "$OUTPUT_FILE"
    cat "$file" >> "$OUTPUT_FILE"
done

echo "Concluído: $OUTPUT_FILE"