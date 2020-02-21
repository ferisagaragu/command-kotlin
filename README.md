## Reactive - command

####Comandos de Reactive
| Código        | Combinación| Descripción|          
| ---- |----|----|
| <code>help</code> |  | Documenta como deben consultar los comandos que contiene Reactive|
| <code>cd</code> | <code>..</code> | Ubica a Reactive en el src principal de tu proyecto|
| <code>cd</code> | <code>/your/project/path</code> | Ubica a Reactive en la carpeta indicada, esta debe estar dentro de <code>src</code>|
| <code>bye</code> <code>exit</code> | | Sale de la consola de Reactive|

####Etiqueta principal
<code>< root /></code>

| Atributos        | Descripción|           
| ---- |----|
| <code>category</code> | Indica en la documentación la categoría donde se agrupara el comando |
| <code>input</code> | Indica en la documentación si requiere un tercer parámetro |



####Imprimir en pantalla
<code><simple-info /></code> <br>
<code><simple-warning /></code> <br>
<code><simple-danger /></code> <br>
<code><simple-success /></code> <br>
<code><simple-important /></code> <br>
<code><simple-detail /></code> <br>
<code><simple-bot /></code> 

<code>< info /></code> <br>
<code>< warning /></code> <br>
<code>< danger /></code> <br>
<code>< success ></code> <br>
<code>< important /></code> <br>
<code>< detail /></code> <br>
<code>< bot /></code>

| Atributos        | Descripción|           
| ---- |----|
| <code>ln</code> | Imprime el texto que contenga la etiqueta y da un salto de linea |

```sh
$ .reactive-info>
$ .reactive-warning>
$ .reactive-danger>
$ .reactive-success>
$ .reactive-important>
$ .reactive-detail>
$ .reactive-bot>
``` 

####Imprimir en pantalla
<code>< layout /></code> <br>

| Atributos        | Descripción|           
| ---- |----|
| <code>extension</code> | Extension que tendrá el archivo cuando se genere |
| <code>contentFolder</code> | Genera un folder con el nombre del archivo <code>example/example.js</code> |
| <code>dir</code> | Folder donde se va a crear por default el archivo |
| <code>suffix</code> | Sufijo que tendrá el archivo al ser creado y en la clase |
| <code>upperCamelCaseFile</code>      | Se creara el nombre del archivo convertido en camel case con la primer letra en mayúscula|
| <code>lowerCamelCaseFile</code>      | Se creara el nombre del archivo convertido en camel case|
| <code>upperSnakeCaseFile</code>      | Se creara el nombre del archivo convertido en snake case con la primer letra en mayúscula|
| <code>lowerSnakeCaseFile</code>      | Se creara el nombre del archivo convertido en snake case|


```sh
$ .reactive-info>
$ .reactive-warning>
$ .reactive-danger>
$ .reactive-success>
$ .reactive-important>
$ .reactive-detail>
$ .reactive-bot>
``` 
