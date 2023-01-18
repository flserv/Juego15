Juego15
Paquete Juego15
El paquete "Juego15" contiene seis clases.
Clase Juego15JFrame
La clase Juego15JFrame contiene la ventana principal del juego. La ventana 
contiene dos paneles. En el primero se presentan las 16 piezas del puzle, una 
de ellas negra, vac�a.
En el segundo hay un cron�metro y tres botones. Al pulsar el primer bot�n se 
desordena el puzle y se pone en marcha el cron�metro. Si se pulsa durante el 
juego se para el cron�metro y se oculta el primer panel. Al pulsarlo otra vez
se vuelve a visualizar el puzle y se vuelve a poner en marcha el cron�metro.
Se juega por teclado, utilizando las teclas de flecha para ordenar los 
movimientos. Cuando el jugador completa el puzle, una ventana anuncia que ha
completado el juego y solicita que introduzca su nombre. Cada vez que se 
completa el puzle se a�ade un nuevo registro (de la clase Record) a la lista
de puntuaciones miRanking (de la clase Ranking). A continuaci�n se abre una 
ventana de la clase "PresentaTablaPntuaciones" con la lista del ranking.
El segundo bot�n abre una nueva ventana que ofrece cuatro opciones:
Crear un nuevo puzle a partir de un archivo de imagen, cambiar el puzle por 
otro, presentar las puntuaciones y salir de la ventana para continuar jugando.
El tercer bot�n termina el juego y cierra el programa.
Las im�genes de cada pieza del puzle est�n en un archivo de extensi�n ".pzl"
que contiene un array de ImageIcon de 16 elementos que se recupera de disco al 
principio del juego o cuando se selecciona "cambiar de puzle".

Clase Tablero
La clase Tablero crea una matriz bidimensional cuadrada cuyos elementos 
representan las casillas del juego. El constructor recibe como argumento un 
entero "ancho" que representa el n�mero de filas/columnas del puzle. Si el argumento 
recibido es menor que la unidad lanza la excepci�n "MenorQueUnoException".
En cada elemento se introduce un entero, comenzando en 0. El �ltimo elemento es 
el que representa la casilla vac�a. Su valor se guarda en la variable
"contenidoCeldaNula". El array "celdaNula" contiene en n�mero de fila y de columna
de la casilla vac�a.

Clase Record
La clase "Record" contiene informaci�n de una partida que ha sido completada.
El m�todo "toStringArray" devuelve un array de String con la informaci�n :
duraci�n del juego en segundos, nombre del jugador, fecha y hora de finalizaci�n
del juego, nombre de la imagen con la que se jug�.

Clase Ranking
La clase Ranking contiene un ArrayList de Record para almacenar las puntuaciones
obtenidas y los m�todos necesarios para serializarlo/deserializarlo , a�adir un
registro y convertirlo en un array de String.

Clase PresentaTablaPuntuaciones
El constructor de la clase PresentaTablaPuntuaciones recibe el ranking en forma 
de array bidimensional de String y lo presenta como una tabla JTable con una 
barra de scroll.

Clase MenorQueUnoException
La clase MenorQueUnoException es la excepci�n que la clase Tablero lanza cuando recibe 
como argumento un entero negativo. El argumento representa el tama�o de una matriz y no 
puede ser negativo.