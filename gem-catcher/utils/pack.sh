#!/bin/bash

cd `dirname $0`
D=$PWD/../../*-android/assets
cd $HOME/software/libgdx
java -cp gdx.jar:extensions/gdx-tools/gdx-tools.jar com.badlogic.gdx.tools.imagepacker.TexturePacker2 $D/texture-raw $D/texture
