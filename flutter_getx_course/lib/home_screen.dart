import 'package:flutter/material.dart';
import 'package:flutter_getx_course/first_screen.dart';
import 'package:get/get.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Home"),
        centerTitle: true,
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Padding(
            padding: EdgeInsets.symmetric(
              horizontal: 20.0,
            ),
            child: MaterialButton(
              onPressed: () {
                //normal routing
                // Navigator.push(
                //   context,
                //   MaterialPageRoute(
                //     builder: (BuildContext context) => FirstScreen(),
                //   ),
                // );
                //getX routing
                // Get.to(FirstScreen(), transition: Transition.leftToRight);
                Get.toNamed('/first');
              },
              textColor: Colors.white,
              shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(25.0),
              ),
              color: Colors.red,
              child: Text("First Screen"),
            ),
          ),
        ],
      ),
    );
  }
}
