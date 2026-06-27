#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"

if ! command -v op >/dev/null 2>&1; then
  echo "1Password CLI (op) is required." >&2
  exit 1
fi

exec op run --env-file="$PROJECT_ROOT/.env" -- mvn -f "$PROJECT_ROOT/pom.xml" exec:java
