import 'package:flutter/material.dart';
import 'package:flutter_getx_course/home_screen.dart';
import 'package:get/get.dart';

class SecondScreen extends StatelessWidget {
  const SecondScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Second Screen"),
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
                // Get.off(HomeScreen());
                //get.off removes the previous or current page
                // Get.back(); //similar to Navigator.pop(context) //getting back to previous page
                // Get.offAll(HomeScreen());
                //complete back with removing all previous pages in way//similar to below method
                // Navigator.pushAndRemoveUntil(
                //     context,
                //     MaterialPageRoute(
                //         builder: (BuildContext context) => HomeScreen()),
                //     (route) => false);

                Get.offAllNamed('/');
              },
              textColor: Colors.white,
              shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(25.0),
              ),
              color: Colors.red,
              child: Text("Home Screen"),
            ),
          ),
        ],
      ),
    );
  }
}
