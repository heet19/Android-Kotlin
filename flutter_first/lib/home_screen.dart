import 'package:flutter/material.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        automaticallyImplyLeading: false,
        title: Text('Home Screen'),
      ),
      body: ListView.builder(
          itemCount: 10,
            itemBuilder: (context,position){
            return Padding(
            padding: padding)
    },
    );
  }
}
