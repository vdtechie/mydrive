@echo off

set /p current_version=<version.txt

set /a new_version=%current_version%+1

echo %new_version% > version.txt

echo New Version: %new_version%