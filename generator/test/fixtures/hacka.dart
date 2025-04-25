// main.dart

import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Hello World',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.compact,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Hello World'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              'Hello World!',
              style: TextStyle(
                fontSize: 24.0,
                fontWeight: FontWeight.bold,
                color: Colors.blue,
              ),
            ),
            Container(
              height: 20.0,
            ),
            Text(
              'Welcome to my first Flutter application',
              style: TextStyle(
                fontSize: 16.0,
              ),
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _showMessage,
        tooltip: 'Show Message',
        child: Icon(Icons.message),
      ),
    );
  }

  void _showMessage() {
    showDialog(
      context: context,
      builder: dialogBuilder,
    );
  }
}

Widget dialogBuilder(BuildContext context) {
  return AlertDialog(
    title: Text('Hello!'),
    content: Text('This is a simple Hello World Flutter application.'),
    actions: <Widget>[
      TextButton(
        onPressed: () => Navigator.of(context).pop(),
        child: Text('OK'),
      ),
    ],
  );
}
