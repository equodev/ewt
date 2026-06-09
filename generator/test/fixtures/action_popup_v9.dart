// action_popup.dart - Popup dialog for action steps in the Knowledge Hub

import 'package:flutter/material.dart' hide Step;
import './model.dart';

class ActionPopup extends StatefulWidget {
  final SubStep subStep;
  final VoidCallback onClose;
  final VoidCallback onNext;
  final bool isLastSubStep;
  const ActionPopup({
    required this.subStep,
    required this.onClose,
    required this.onNext,
    this.isLastSubStep = false
  });

  @override
  State<ActionPopup> createState() => _ActionPopupState();
}

class _ActionPopupState extends State<ActionPopup> with SingleTickerProviderStateMixin {
  late AnimationController _animationController;
  late Animation<double> _animation;
  bool _isActionButtonHovered = false;

  @override
  void initState() {
    super.initState();

    // Setup animation
    _animationController = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 300),
    );

    _animation = CurvedAnimation(
      parent: _animationController,
      curve: Curves.easeInOut,
    );

    _animationController.forward();
  }

  @override
  void dispose() {
    _animationController.dispose();
    super.dispose();
  }

  String get _buttonText {
    if (widget.subStep.currentAction >= widget.subStep.actions.length - 1) {
      return widget.isLastSubStep ? 'Finish Step' : 'Next Substep';
    }
    return 'Next';
  }

  @override
  Widget build(BuildContext context) {
    return AnimatedBuilder(
      animation: _animation,
      builder: (bldContext, child) {
        return Transform.scale(
          scale: _animation.value,
          child: Opacity(
            opacity: _animation.value,
            child: child,
          ),
        );
      },
      child: Material(
        color: Colors.transparent,
        child: Stack(
          clipBehavior: Clip.none, // Allow elements to render outside container boundaries
          children: [
            // Main popup content
            Container(
              width: 300,
              decoration: BoxDecoration(
                color: const Color(0xFF3F51B5),
                borderRadius: BorderRadius.circular(8),
                boxShadow: [
                  BoxShadow(
                    color: Colors.black26,
                    blurRadius: 10,
                    offset: const Offset(0, 4),
                  ),
                ],
              ),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                mainAxisSize: MainAxisSize.min,
                children: [
                  // Header with close button
                  Padding(
                    padding: const EdgeInsets.only(top: 8, right: 8),
                    child: Align(
                      alignment: Alignment.topRight,
                      child: IconButton(
                        icon: const Icon(Icons.close, color: Colors.white70, size: 18),
                        onPressed: () {
                          _animationController.reverse().then((_) {
                            widget.onClose();
                          });
                        },
                        padding: const EdgeInsets.all(4),
                        constraints: const BoxConstraints(),
                        iconSize: 18,
                        splashRadius: 16,
                      ),
                    ),
                  ),

                  // Main content
                  Padding(
                    padding: const EdgeInsets.fromLTRB(16, 0, 16, 16),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        // Title in bold
                        Text(
                          'Click Record icon to start',
                          style: const TextStyle(
                            color: Colors.white,
                            fontSize: 15,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                        const SizedBox(height: 12),

                        // Description with partially bold text
                        RichText(
                          text: TextSpan(
                            style: const TextStyle(
                              color: Colors.white,
                              fontSize: 14,
                            ),
                            children: [
                              TextSpan(
                                text: getCurrentActionSteps().sublist(0, 2).join(' ') + ' ',
                                style: const TextStyle(fontWeight: FontWeight.bold),
                              ),
                              TextSpan(
                                text: getCurrentActionSteps().sublist(2).join(' '),
                              ),
                            ],
                          ),
                        ),

                        // Example action button with icon - only shown for the first action
                        if (widget.subStep.currentAction == 0)
                          Padding(
                            padding: const EdgeInsets.only(top: 16),
                            child: Row(
                              mainAxisAlignment: MainAxisAlignment.start,
                              children: [
                                MouseRegion(
                                  onEnter: (_) => setState(() => _isActionButtonHovered = true),
                                  onExit: (_) => setState(() => _isActionButtonHovered = false),
                                  child: Container(
                                    padding: const EdgeInsets.all(8),
                                    decoration: BoxDecoration(
                                      color: _isActionButtonHovered ? Colors.white.withOpacity(0.2) : Colors.transparent,
                                      borderRadius: BorderRadius.circular(4),
                                    ),
                                    child: Row(
                                      children: [
                                        Icon(
                                          Icons.play_circle_outline,
                                          color: Colors.white,
                                          size: 20,
                                        ),
                                        const SizedBox(width: 8),
                                        Text(
                                          'Start Recording',
                                          style: const TextStyle(
                                            color: Colors.white,
                                            fontSize: 13,
                                          ),
                                        ),
                                      ],
                                    ),
                                  ),
                                ),
                              ],
                            ),
                          ),
                      ],
                    ),
                  ),

                  // Divider
                  Container(
                    height: 1,
                    color: Colors.white.withOpacity(0.2),
                  ),

                  // Bottom bar with counter and next button
                  Padding(
                    padding: const EdgeInsets.all(12),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        // Counter in bottom left
                        Text(
                          '${widget.subStep.currentAction + 1}/${widget.subStep.actions.length}',
                          style: const TextStyle(
                            color: Colors.white70,
                            fontSize: 12,
                          ),
                        ),

                        // Next button with border
                        OutlinedButton(
                          onPressed: () {
                            if (widget.subStep.currentAction >= widget.subStep.actions.length - 1) {
                              _animationController.reverse().then((_) {
                                widget.onNext();
                              });
                            } else {
                              setState(() {
                                widget.subStep.currentAction++;
                              });
                            }
                          },
                          style: OutlinedButton.styleFrom(
                            backgroundColor: const Color(0xFF3F51B5),
                            side: const BorderSide(color: Colors.white, width: 1),
                            shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(4),
                            ),
                            padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
                          ),
                          child: Text(
                            _buttonText,
                            style: const TextStyle(
                              color: Colors.white,
                              fontWeight: FontWeight.bold,
                              fontSize: 13,
                            ),
                          ),
                        ),
                      ],
                    ),
                  ),
                ],
              ),
            ),


            // Left triangle
            Positioned(
              left: -8,
              top: 20,
              child: Container(
                width: 0,
                height: 0,
                decoration: const BoxDecoration(
                  color: Colors.transparent,
                ),
                child: CustomPaint(
                  size: const Size(10, 15),
                  painter: TrianglePainter(),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  List<String> getCurrentActionSteps() => widget.subStep.actions[widget.subStep.currentAction].split(' ');
}

// Triangle painter for the popup
class TrianglePainter extends CustomPainter {
  @override
  void paint(Canvas canvas, Size size) {
    final paint = Paint()
      ..color = const Color(0xFF3F51B5)
      ..style = PaintingStyle.fill;

    final path = Path()
      ..moveTo(size.width, size.height / 2)  // Right middle
      ..lineTo(0, 0)                        // Top left
      ..lineTo(0, size.height)              // Bottom left
      ..close();                            // Close the path

    canvas.drawPath(path, paint);
  }

  @override
  bool shouldRepaint(CustomPainter oldDelegate) => false;
}

// Demo example of using the ActionPopup
class ActionPopupDemo extends StatefulWidget {
  const ActionPopupDemo();

  @override
  State<ActionPopupDemo> createState() => _ActionPopupDemoState();
}

class _ActionPopupDemoState extends State<ActionPopupDemo> {
  final List<Step> steps = KnowledgeHubData.getSteps();
  bool isPopupVisible = true;
  int currentStep = 0;
  int currentSubStep = 0;

  void closePopup() {
    setState(() {
      isPopupVisible = false;
    });
  }

  void nextAction() {
    setState(() {
      final currentSubStepObj = steps[currentStep].subSteps[currentSubStep];
      currentSubStepObj.isCompleted = true;

      // Check if we need to move to next substep
      if (currentSubStep < steps[currentStep].subSteps.length - 1) {
        currentSubStep++;
      } else {
        // Move to next step if available
        if (currentStep < steps.length - 1) {
          currentStep++;
          currentSubStep = 0;
        }
      }

      // Ensure popup is visible for the next action
      isPopupVisible = true;
    });
  }

  void showPopup() {
    setState(() {
      // Reset to first action of first substep of first step
      currentStep = 0;
      currentSubStep = 0;
      steps[0].subSteps[0].currentAction = 0;
      isPopupVisible = true;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Action Popup Demo'),
        backgroundColor: const Color(0xFF3F51B5),
      ),
      body: Stack(
        children: [
          // Background content
          Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(
                  'Step ${currentStep + 1}: ${steps[currentStep].title}',
                  style: const TextStyle(
                    fontSize: 18,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                const SizedBox(height: 8),
                Text(
                  'Substep: ${steps[currentStep].subSteps[currentSubStep].text}',
                  style: const TextStyle(fontSize: 16),
                ),
                const SizedBox(height: 24),
                ElevatedButton(
                  onPressed: isPopupVisible ? closePopup : showPopup,
                  style: ElevatedButton.styleFrom(
                    backgroundColor: const Color(0xFF3F51B5),
                  ),
                  child: Text(isPopupVisible ? 'Hide Popup' : 'Show Popup'),
                ),
                const SizedBox(height: 100),
                // Target for the arrow
                Container(
                  padding: const EdgeInsets.all(8),
                  decoration: BoxDecoration(
                    border: Border.all(color: const Color(0xFF3F51B5)),
                    borderRadius: BorderRadius.circular(4),
                  ),
                  child: const Icon(
                    Icons.play_circle_outline,
                    color: Color(0xFF3F51B5),
                    size: 32,
                  ),
                ),
              ],
            ),
          ),

          // Action Popup
          if (isPopupVisible)
            Positioned(
              top: 100,
              left: 50,
              child: ActionPopup(
                subStep: steps[currentStep].subSteps[currentSubStep],
                onClose: closePopup,
                onNext: nextAction,
                isLastSubStep: currentSubStep == steps[currentStep].subSteps.length - 1,

              ),
            ),
        ],
      ),
    );
  }
}

void main() {
  runApp(const MaterialApp(
    home: ActionPopupDemo(),
  ));
}