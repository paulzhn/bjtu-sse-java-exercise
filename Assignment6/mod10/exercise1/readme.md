尝试使用`GridBagLayout`。然而一个很奇怪的问题：根据官方的示例代码：

```java
GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            //natural height, maximum width
            c.fill = GridBagConstraints.HORIZONTAL;
        }

        button = new JButton("Button 1");
        if (shouldWeightX) {
            c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton("Button 2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(button, c);
//...
```

可以看出来这个`GridBagConstraints c`始终是同一个对象。那么问题来了：`pane.add()`add的是什么呢？看起来是只有参数，而不是传递的对象。在https://blog.csdn.net/xietansheng/article/details/72814552 中则提到，每次使用`GridBagConstraints c`都必须new一个新的对象出来。这里应当有误。

**1:15 update**: 虽然c这个对象可以复用，然而很大的一个问题是：当给前一个Component设置了Constraint之后，再给另一个设置，就很容易出现忘记改c的参数的情况，于是将错误的属性赋给了另一个控件，于是就容易搞出一些奇怪的问题。解决这个问题也简单，每用一次`GridBagConstraints`都new一次就行了，反正jvm垃圾回收（~~@上海~~）一搞也不浪费内存，就是可能代码看起来难看点（？)

添加一个button再添加第二个的时候，添加不进去。代码是：

```java
		textArea = new JTextArea(10, 50);
        scrollPane = new JScrollPane(textArea);
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 5;
        panel.add(scrollPane, c);

        btnSend = new JButton("Send");
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTH;
        panel.add(btnSend, c);

        btnQuit = new JButton("Quit");
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.NORTH;
        panel.add(btnQuit, c);
```

**22:56 update:** 很奇怪， 把`JTextArea`的代码放在最后就能出来效果了，这是为什么？

答：因为`c.gridheight`在给`JTextArea`用完之后忘记改了就直接给了`JButton`用，于是乎`Save`的`gridheight`也被搞成了5，直接把`Quit`盖住了。

**1:15 update:** `weightx `和`weighty`与`fill`也有关，不调`fill`的话两个weight改了也没有用。

**13:02 update:** 创建`JFrame`之后，其上将会创建一个默认的`rootPanel`；因此，在使用自己的`JPanel`的时候，要`frame.getContentPane().add(panel)`而不能直接`frame.add(panel)`。后一种方法添加进去的`panel`与`rootPanel`是平级的，前一种才能让`rootPanel`成为`panel`的父级。





