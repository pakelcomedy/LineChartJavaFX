# LineChartJavaFX Project

## Overview

The **LineChartJavaFX** project demonstrates how to create and manage a collection of line charts using JavaFX. JavaFX is a software platform for creating and delivering desktop applications, as well as rich internet applications that can run across a wide variety of devices.

This project is designed to help you understand the fundamentals of creating line charts in JavaFX and managing them within a JavaFX application. It includes examples of how to set up the charts, customize their appearance, and add them to a user interface.

## Features

- **Creation of Line Charts**: Learn how to create line charts using JavaFX.
- **Customization**: Customize the appearance of your line charts, including colors, labels, and legends.
- **Data Management**: Add and update data points dynamically.
- **User Interaction**: Implement features to interact with the charts, such as zooming and panning.

## Requirements

- **Java 11 or higher**: Ensure you have Java Development Kit (JDK) 11 or later installed.
- **JavaFX SDK**: Download and set up the JavaFX SDK compatible with your JDK.
- **IDE**: It is recommended to use an IDE such as IntelliJ IDEA, Eclipse, or NetBeans for easier project management and code editing.

## Setup

1. **Install Java**: Download and install the latest version of JDK from the [Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
2. **Install JavaFX**: Download JavaFX SDK from the [Gluon website](https://gluonhq.com/products/javafx/).
3. **Configure IDE**: Set up your IDE to recognize JavaFX. This involves configuring the JavaFX libraries in your project settings.

## Project Structure

```
LineChartJavaFX/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── pakelcomedy/
│   │   │           └── linechartjavafx/
│   │   │               ├── Main.java
│   │   │               ├── LineChartController.java
│   │   │               └── LineChartModel.java
│   │   └── resources/
│   │       └── com/
│   │           └── pakelcomedy/
│   │               └── linechartjavafx/
│   │                   └── styles.css
│   └── test/
│       └── java/
│           └── com/
│               └── pakelcomedy/
│                   └── linechartjavafx/
│                       └── LineChartTest.java
├── build.gradle
└── README.md
```

## Usage

### Running the Application

1. **Clone the Repository**: Clone the project repository to your local machine.
   ```sh
   git clone https://github.com/pakelcomedy/LineChartJavaFX.git
   ```
2. **Open in IDE**: Open the project in your preferred IDE.
3. **Run the Main Class**: Locate `Main.java` and run it to start the application.

### Adding a Line Chart

To add a new line chart to the application:

1. Create an instance of `LineChartModel` with the necessary data.
2. Use `LineChartController` to add the chart to the scene.
3. Customize the chart appearance and data points as needed.

### Screenshot

![image 12](https://github.com/pakelcomedy/LineChartJavaFX/assets/92992500/8c3e91d6-4f2d-4d48-b2b1-c273e83ffe15) ![image](https://github.com/pakelcomedy/LineChartJavaFX/assets/92992500/8f8d105e-e670-494c-985c-b1e09887fee0)

## Contribution

Contributions are welcome! If you would like to contribute to the project, please fork the repository and submit a pull request. For major changes, please open an issue to discuss what you would like to change.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.

## Contact

If you have any questions or suggestions, feel free to contact me at [danieldna1411@gmail.com](mailto:danieldna1411@gmail.com).

---

This README provides an overview of the LineChartJavaFX project, including setup instructions, usage examples, and guidelines for contribution. Enjoy creating and managing your line charts with JavaFX!
