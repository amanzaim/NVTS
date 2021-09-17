# NVTS
Project done for my final year project in Diploma, it is incomplete by itself because the other half of the project is done by another person. This project assumes that the person who is visiting the neighbourhood already has the QR code which was generated during the first half of the project. The project was developed using Java in Netbeans.

## Features

1. Scan QR codes
2. Capture image of the person who scanned
3. Keep both the data on the QR code and the image in a database

## How it works

1. The application automatically captures any QR code that passes through its camera (in this case I made my webcam a camera)
2. If the contents of the QR code is available in the database, capture a picture of the person scanning the QR code, put into database and let him pass. Also, let the person who he's visiting know that he has arrived through telegram (using telegrambots) 
    * If the contents of the QR code is not in the database, capture a picture of the person, put it into suspicious person list and dont let him pass
3. When going out, the same QR code is used to detect when and if the visitor comes out of the neighbourhood.


## Languages used

Java

## Libs used

1. telegrambots API
2. java.awt
3. java.swing
4. javax.swing
5. java.util
6. java.sql
7. java.io
8. java.imageio
9. java.text
10. github.sarxos.webcam
11. google.zxing

## License

MIT Licensed
