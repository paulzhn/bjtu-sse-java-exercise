What is the difference between method `getDocument()` and `getText()`?

区别大得很：后者返回的是一个`String`，前者返回的是一个`Document`的对象。然而`Document`是个接口，当然也有与之对应的抽象类`AbstractDocument`。

于是又有疑问：`JTextComponent`的源码里实现的是`Document`这个接口，然而当调用方法时，执行的却是抽象类`AbstractDocument`中的方法。这一点是怎么做到的呢？

答：大概是intellj的bug吧，找方法没有找对...事实上，在`new JTextArea()`的时候，也会new一个`PlainDocument`出来，它extends了`AbstractDocument`这个类。

Question: `Jframe`可以直接`setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)`，还需要再

> Create a `WindowListener` which will quit the program when the close widget is pressed on the frame

吗？

Notice: one confusing between `windowClosed` and `windowClosing`

To finish this exercise, maybe you will comment code

```java
//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
```

and override the method `windowClosed`. However, you'll find that the program doesn't exit correctly. This is because if you comment out that line, the close widget behavior will be default, which is `HIDE_ON_CLOSE`. In that case, the window is not actually closed instead of hidden, so the method `windowsClosed` cannot be invoked.

Another question: in the oracle's java tutorials, there is a piece of codes:

```java
public void windowClosing(WindowEvent e) {
        displayMessage("WindowListener method called: windowClosing.");
        //A pause so user can see the message before
        //the window actually closes.
        ActionListener task = new ActionListener() {
            boolean alreadyDisposed = false;
            public void actionPerformed(ActionEvent e) {
                if (frame.isDisplayable()) {
                    alreadyDisposed = true;
                    frame.dispose();
                }
            }
        };
        Timer timer = new Timer(500, task); //fire every half second
        timer.setInitialDelay(2000);        //first delay 2 seconds
        timer.setRepeats(false);
        timer.start();
    }
```

however, why should it `new` a `ActionListener`? In which case would it be invoked?