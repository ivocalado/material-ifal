#!/bin/bash

diretorio="$1"

mkdir material-ifal
cd material-ifal
git init
git remote add -f origin https://github.com/txithihausen/material-ifal.git

git config core.sparseCheckout true

echo $diretorio >> .git/info/sparse-checkout
