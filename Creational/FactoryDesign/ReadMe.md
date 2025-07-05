---

## 🏭 FACTORY DESIGN PATTERN — ALL YOU NEED TO KNOW

---

### 🧠 WHAT IS IT?

> A creational pattern that **delegates object creation** to a **centralized factory**, hiding the `new` logic from client code.

Instead of:

```java
Vehicle v = new Car();
```

You do:

```java
Vehicle v = VehicleFactory.getVehicle("car");
```

---

### 🎯 WHEN TO USE (PRACTICAL REASONS)

| Use Case                                                                                       | Why Factory Pattern Helps                |
| ---------------------------------------------------------------------------------------------- | ---------------------------------------- |
| 🔁 You have **multiple types of objects** that implement a common interface (Car, Bike, Truck) | Choose which one to create at runtime    |
| 🔀 Creation depends on **runtime input/config/env**                                            | You want to hide `new` logic             |
| 🧱 You want to **abstract and decouple** object creation from usage                            | Keeps client code clean                  |
| 😵 Complex or error-prone constructor logic                                                    | Factory handles that for you             |
| 🔌 Plugin, driver, or handler selection                                                        | Factory dynamically returns right object |

---

### ❌ WHEN NOT TO USE

| Situation                                  | Why Factory is Overkill                        |
| ------------------------------------------ | ---------------------------------------------- |
| You only have **one class**                | No point in a factory                          |
| You always want to use **the same object** | Just call `new` directly                       |
| The object has many config steps           | Use **Builder**, not Factory                   |
| You want full object control               | Factory returns base type only (limits access) |

---

### 📦 STRUCTURE

```text
            +----------------------+
            |    Vehicle (interface) |
            +----------------------+
                /            \
         +-------+        +------+
         |  Car  |        | Bike |
         +-------+        +------+
                ^
                |
     +------------------------+
     |   VehicleFactory       |
     +------------------------+
     | getVehicle(String type)|
     +------------------------+
```

---

### 🧠 WHAT YOU GAIN

| Advantage                    | Why It Helps                                 |
| ---------------------------- | -------------------------------------------- |
| ✅ Clean client code          | No need to `new` different classes           |
| ✅ Easily extendable          | Add new types without breaking existing code |
| ✅ Promotes loose coupling    | Code uses interface, not implementation      |
| ✅ Centralized creation logic | All object creation happens in one place     |

---

### ⚠️ LIMITATION

* Factory **returns interface type**, so:

  ```java
  Vehicle v = VehicleFactory.getVehicle("car");
  v.openSunroof(); // ❌ Won’t work unless openSunroof is in Vehicle
  ```

* To access specific features, you'd need:

  * `instanceof` + cast (not ideal)
  * Or avoid using a factory in such case

---

### 🔥 REAL-LIFE EXAMPLES

| Use Case                            | Description                                              |
| ----------------------------------- | -------------------------------------------------------- |
| `LoggerFactory.getLogger()`         | Hides whether you're using file, DB, or console logger   |
| `ConnectionFactory.getConnection()` | DB driver loaded at runtime                              |
| Payment gateways                    | `PaymentFactory.get("razorpay")` returns right processor |
| Game engines                        | Spawn different types of `Enemy`, `PowerUp`, etc.        |
| Android                             | `LayoutInflater.from(context).inflate(...)` is a factory |

---

## ✅ TL;DR (copy this to your notes)

* Factory Pattern lets you **create objects without exposing class names**.
* Use it when:

  * You have **multiple implementations**
  * Creation depends on **input/config**
  * You want **loose coupling**
* Don't use when:

  * Only one implementation
  * You need full object control or config steps
* Factory returns **interface/abstract type**, so you only access **common methods**.

---

### Code Walkthrough


![alt text](<Factory.jpg>)

### Summary

+ when you have multiple way of creating a class that has common interface (Characteristics), then we can use factory create any object of the class of choice, by hiding away the object creation details.

+ Ex: CarFactory can produce sports car, commerical car, luxury car etc.