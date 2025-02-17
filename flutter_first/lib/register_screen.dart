import 'package:flutter/material.dart';
import 'package:flutter_first/login_screen.dart';

class RegisterScreen extends StatefulWidget {
  const RegisterScreen({Key? key}) : super(key: key);

  @override
  State<RegisterScreen> createState() => _RegisterScreenState();
}

class _RegisterScreenState extends State<RegisterScreen> {
  TextEditingController userNameController = TextEditingController();
  TextEditingController emailController = TextEditingController();
  TextEditingController passwordController = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Register Screen'),
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
                      labelText: 'Email',
                      hintText: 'Enter Email',
                      prefixIcon: Icon(Icons.email),
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
                Navigator.push(context, MaterialPageRoute(builder: (context) => LoginScreen()));
                ScaffoldMessenger.of(context).showSnackBar(snackBar(context: Text(userNameController.text)));
              }, child: Text('Elevated Button'),),

              OutlinedButton(onPressed: () {
                print('abcde');
              }, child: Text('Outline Button'),),

              TextButton(onPressed: () {}, child: Text('Text Button'),),
            ],
          ),),
        ],
      ),
    );
  }
}
