import 'package:flutter/material.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({Key? key}) : super(key: key);

  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  TextEditingController userNameController = TextEditingController();
  TextEditingController passwordController = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        automaticallyImplyLeading: false,
        title: Text('Login Screen'),
      ),
      body: Column(
        children: [
          Form(child: Column(
            children: [
              Padding(
                padding: const EdgeInsets.all(8.0),
                child: TextFormField(
                  controller: userNameController,
                  decoration: InputDecoration(
                      labelText: 'Username',
                      hintText: 'Enter username',
                      prefixIcon: Icon(Icons.person),
                      border: OutlineInputBorder()
                  ),
                ),
              ),

              Padding(
                padding: const EdgeInsets.all(8.0),
                child: TextFormField(
                  controller: userNameController,
                  decoration: InputDecoration(
                      labelText: 'Password',
                      hintText: 'Enter Password',
                      prefixIcon: Icon(Icons.password),
                      border: OutlineInputBorder()
                  ),
                ),
              ),
              ElevatedButton(onPressed: () {
                Navigator.push(context, MaterialPageRoute(builder: (context) => HomeScreen()));
                ScaffoldMessenger.of(context).showSnackBar(snackBar(context: Text(userNameController.text)));
              }, child: Text('Elevated Button'),),

            ],
          ),),
        ],
      ),
      );
  }
}
