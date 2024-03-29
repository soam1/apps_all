import 'package:flutter/material.dart';
import 'package:flutter_getx_course/home_screen.dart';
import 'package:flutter_getx_course/second_screen.dart';
import 'package:get/get.dart';

import 'first_screen.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      initialRoute: '/',
      getPages: [
        GetPage(
            name: '/',
            page: () => HomeScreen(),
            transition: Transition.leftToRight),
        GetPage(
            name: '/first',
            page: () => FirstScreen(),
            transition: Transition.rightToLeft),
        GetPage(
            name: '/second',
            page: () => SecondScreen(),
            transition: Transition.downToUp),
      ],
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      // home: const HomeScreen(),
    );
  }
}
