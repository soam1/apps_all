import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:flutter_widgets/signup.dart';

Future<void>main() async{
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();
  runApp(MyApp());

}
class MyApp extends StatelessWidget{
@override
  Widget build(BuildContext context) {
    // TODO: implement build
      return MaterialApp(
      home: HomePage(),
      );
  }
}
class HomePage extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    return Scaffold(
        appBar: AppBar(
          title: Text("Signup using firebase"),
        ),
      body: Container(
        alignment: Alignment.center,
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              child: Text("SignUp"),
              onPressed: (){
                Navigator.push(context, MaterialPageRoute(builder: (context)=> SignUpPage()));
              },
            ),
          ],
        ),
      ),
    );
  }
}