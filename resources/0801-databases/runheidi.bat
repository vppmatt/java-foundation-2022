echo off
if not exist heidisql\ (
mkdir heidisql
cd heidisql
call curl -LO https://www.heidisql.com/downloads/releases/HeidiSQL_12.0_64_Portable.zip
call tar -xf HeidiSQL_12.0_64_Portable.zip
rm HeidiSQL_12.0_64_Portable.zip
) else (
cd heidisql
)
call heidisql.exe
