#!/bin/bash

diretorio="$1"

atual=`pwd`
destino=`mktemp -d`
url="https://github.com/txithihausen/material-ifal.git"

cd $destino
git init
git remote add -f origin $url

git config core.sparseCheckout true

echo $diretorio >> .git/info/sparse-checkout

git pull origin master

mv $diretorio $atual
rm -rf $destino
