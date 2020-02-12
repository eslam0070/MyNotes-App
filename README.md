# MyNotes
## Retrofit

![Image description](https://i1.wp.com/blogs.innovationm.com/wp-content/uploads/2018/07/Retrofit_Library.png?fit=624%2C354)

Retrofit is an awesome type-safe HTTP client for Android and Java built by awesome folks at Square. Retrofit makes it easy to consume JSON or XML data which is parsed into Plain Old Java Objects (POJOs).

[If you just want to get the sample project, then you can find it here.
](https://github.com/prakashpun/RetrofitTutorial)

## What is MVP?

![Image description](https://miro.medium.com/max/778/1*TuWeZzR14MmB-RBbjtZl-A.png)


The MVP pattern allows separating the presentation layer from the logic so that everything about how the UI works is agnostic from how we represent it on screen. Ideally, the MVP pattern would achieve that the same logic might have completely different and interchangeable views.

The first thing to clarify is that MVP is not an architecture by itself, it’s only responsible for the presentation layer. This has been a controversial assessment, so I want to explain it a bit deeper.

You may find that MVP is defined as an architectural pattern because it can become part of the architecture of your App, but don’t consider that just because you are using MVP, your architecture is complete. MVP only models the presentation layer, but the rest of layers will still require a good architecture if you want a flexible and scalable App.

An example of a complete architecture could be Clean Architecture, though there are many other options.

In any case, it is always better to use it for your architecture that not using it at all.

## Why use MVP?

In Android, we have a problem arising from the fact that Android activities are closely coupled to both UI and data access mechanisms. We can find extreme examples such as CursorAdapter, which mixes adapters, which are part of the view, with cursors, something that should be relegated to the depths of data access layer.

For an application to be easily extensible and maintainable, we need to define well-separated layers. What do we do tomorrow if, instead of retrieving the same data from a database, we need to do it from a web service? We would have to redo our entire view.

MVP makes views independent from our data source. We divide the application into at least three different layers, which lets us test them independently. With MVP we take most of the logic out from the activities so that we can test it without using instrumentation tests.


