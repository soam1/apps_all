import 'dart:math';

import 'package:audioplayers/audioplayers.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  int count = 0;
  Color brown = Colors.brown;
  Color black = Colors.black;

  List<Color> colors = [
    Colors.white,
    Colors.teal,
    Colors.black,
    Colors.pinkAccent,
    Colors.purple,
    Colors.greenAccent,
  ];
  int appBar = 0, scaffold = 0;
  Color temp = Colors.orange;
  Random random = new Random();

  // String cantina = "cantinaband3.wav";
  List sounds = ["cantinaband3.wav","preamble10.wav","starwars3.wav"];
  int soundPosition = 0;
  final playerr = AudioPlayer();

  @override
  Widget build(BuildContext context) {
    // return const Placeholder();
    return new MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          centerTitle: true,
          backgroundColor: colors[appBar],
          // title: Text("$count"),
          title: IconButton(
            icon: Icon(
              Icons.refresh,
              color: (Colors.blueAccent),
            ),
            onPressed: () {
              soundPosition = random.nextInt(3);
            },
          ),
        ),
        backgroundColor: colors[scaffold],
        body: MaterialButton(
          child: Image.asset("images/dashatar.png"),
          onPressed: () {
            setState(() {
              ++count;
              // temp = brown;
              // brown = black;
              // black = temp;
              appBar = random.nextInt(5);
              scaffold = random.nextInt(5);
              playerr.play(AssetSource(sounds[soundPosition]));
            });
          },
        ),
      ),
    );
  }
}
