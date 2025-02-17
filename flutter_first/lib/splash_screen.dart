import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter_first/register_screen.dart';
import 'package:lottie/lottie.dart';

class SplashScreen extends StatelessWidget {
  const SplashScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    Timer(Duration(seconds: 4), () {
      Navigator.push(
        context,
        MaterialPageRoute(
          builder: (context) => const RegisterScreen(),
        ),
      );
    });
    return Scaffold(
      body: SafeArea(
          child: Lottie.asset('assets/images/splash.json')),
    );
  }
}
