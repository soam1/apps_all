  import 'package:flutter/material.dart';
  class SignUpPage extends StatelessWidget{
    @override
    Widget build(BuildContext context) {
      // TODO: implement build
      return Scaffold(
        body: Container(
          alignment: Alignment.center,
  margin: const EdgeInsets.all(30),
  child: Column(
    mainAxisAlignment: MainAxisAlignment.center,
    children: [
      Container(
        margin: const EdgeInsets.all(10),

        decoration: BoxDecoration(
          color: Colors.green,
          borderRadius: BorderRadiusDirectional.circular(20),
        ),
        child: TextFormField(
          decoration: const InputDecoration(
            labelText: "Enter User name:",
            icon: Icon(Icons.person),
            hintText: "John Soam",
          ),
        ),
      ),
      Container(
        margin: const EdgeInsets.all(10),
        decoration: BoxDecoration(
          color: Colors.green,
          borderRadius: BorderRadiusDirectional.circular(20),
        ),
        child: TextFormField(
          decoration: const InputDecoration(
            labelText: "Enter User email:",
            icon: Icon(Icons.inbox),
            hintText: "john003@gmail.com",
          ),
        ),
      ),
      Container(
        margin: const EdgeInsets.all(10),
        decoration: BoxDecoration(
          color: Colors.green,
          borderRadius: BorderRadiusDirectional.circular(20),
        ),
        child: TextFormField(
          obscureText: true,
          decoration: const InputDecoration(
            labelText: "Enter User password:",
            icon: Icon(Icons.password),
            hintText: "12345678",
          ),
        ),
      ),
      Container(
        height: 100,
        width: 250,
        decoration: BoxDecoration(
          color: Colors.pinkAccent,
          borderRadius: BorderRadiusDirectional.circular(30),

        ),
        child: ElevatedButton(
          child: const Text("Sign up"),
          onPressed: (){          },
            // com.example.flutter_widgets
        ),

      ),
    ],
  ),
      ),
      );
    }
  }