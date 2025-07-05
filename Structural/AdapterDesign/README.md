---

# ✅ Adapter Design Pattern — All You Need to Know

---

## 🚩 What is it?

**Adapter Pattern** is a structural design pattern used to **make two incompatible interfaces work together**.

> It wraps an **old or incompatible class** and exposes it through a **new interface** that your system expects.

---

## 🧠 Real-World Analogy

> Think of a **power plug adapter**.
> Your laptop charger has a 3-pin plug, but the wall has only 2-pin sockets.
> You don’t change the laptop or the wall — you use an **adapter**.

---

## 🔧 Structure

```
Client → [Target Interface] ← Adapter → Adaptee (legacy/incompatible class)
```

| Component            | Role                                                                   |
| -------------------- | ---------------------------------------------------------------------- |
| **Target Interface** | What your system expects                                               |
| **Adaptee**          | The existing class you can’t or don’t want to modify                   |
| **Adapter**          | The bridge — wraps the Adaptee and makes it match the Target Interface |
| **Client**           | Code that uses the Target Interface                                    |

---

## 👨‍💻 Code Example (User Service)

### 1. 🎯 Target Interface (your app expects this)

```java
interface UserRepository {
    List<User> fetchAllUsers();
}
```

---

### 2. 🧱 Adaptee — Legacy or incompatible service

```java
class LegacyUserService {
    public User[] getAllUsersAsArray() {
        return new User[] {
            new User("Alice", 30),
            new User("Bob", 28)
        };
    }
}
```

---

### 3. 🧩 Adapter — Makes LegacyUserService work like UserRepository

```java
class LegacyUserAdapter implements UserRepository {
    private final LegacyUserService legacyService;

    public LegacyUserAdapter(LegacyUserService legacyService) {
        this.legacyService = legacyService;
    }

    @Override
    public List<User> fetchAllUsers() {
        return Arrays.asList(legacyService.getAllUsersAsArray());
    }
}
```

---

### 4. ✅ Client Code (your app)

```java
public class Main {
    public static void main(String[] args) {
        UserRepository repo = new LegacyUserAdapter(new LegacyUserService());
        List<User> users = repo.fetchAllUsers();
        users.forEach(System.out::println);
    }
}
```

---

## 🧠 When to Use Adapter

| Use Adapter when...                                   | Reason                                       |
| ----------------------------------------------------- | -------------------------------------------- |
| You **can’t modify** the original class               | It’s legacy, closed-source, or risky         |
| You’re **migrating** to a new interface               | Allows a smooth transition                   |
| You have to **standardize interfaces** across the app | Keeps client code clean and decoupled        |
| You want **backward compatibility**                   | Adapter bridges old and new without breakage |

---

## 🚫 When Not to Use Adapter

| Don’t use Adapter if...                        | Do this instead                              |
| ---------------------------------------------- | -------------------------------------------- |
| You’re building the class from scratch         | Just implement the target interface directly |
| You can change the original class safely       | Refactor it to match the interface           |
| You don’t need multiple formats or abstraction | Keep it simple, no pattern needed            |

---

## ✅ Pros

* ✔ Allows reuse of existing, legacy, or third-party code
* ✔ Keeps codebase clean and consistent
* ✔ No need to rewrite or refactor the original class
* ✔ Helps with gradual system upgrades

## ❌ Cons

* ❌ Adds an extra layer of indirection
* ❌ If overused, leads to cluttered adapter classes
* ❌ Doesn’t solve problems where behavior, not just interface, is incompatible

---

## 💡 Real-World Examples

| Domain      | Adapter Example                                                   |
| ----------- | ----------------------------------------------------------------- |
| Web APIs    | You send JSON, but the API accepts XML — adapter converts formats |
| Logging     | Old logger uses `writeLog(String)`, new expects `log(Level, msg)` |
| Collections | Adapter to convert `Enumeration` to `Iterator` (Java built-in)    |
| Android     | `RecyclerView.Adapter` — adapts data model to UI                  |
| Payments    | Adapter wraps Razorpay API to match a generic `PaymentGateway`    |
| Databases   | Adapter turns old JDBC code into Repository pattern               |

---

## 🔁 Adapter ≠ Wrapper ≠ Facade

| Pattern     | Purpose                                              |
| ----------- | ---------------------------------------------------- |
| **Adapter** | Make an incompatible interface match what you expect |
| **Wrapper** | General term; may or may not adapt anything          |
| **Facade**  | Simplify and unify multiple interfaces into one      |

---

## 🧠 TL;DR

> Use **Adapter Pattern** when you want to make **old, incompatible, or third-party code** work with your current interface — **without modifying the original class**.


### Summary

You have a new requirement, but your existing (old) code doesn’t comply with it — and you can’t change the old code directly. This might be due to migration challenges, risk factors, time constraints, or organizational policies. So, you create an adapter that takes the old class and wraps it to make it work with the new requirement, without modifying the original code

new requirement -> target interface
old logic -> old class
adapter -> implements the target interface by adapting or transforming the logic or output of the old class to fit the new requirement.


### Code Walkthrough


![alt text](<adapter Design_0.jpg>)
