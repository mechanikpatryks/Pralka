# 🧺 Urządzenia domowe – Pralka i Odkurzacz (Android Studio)

Alikacja na Androida, która pokazuje dwa **urządzenia domowe**: **pralkę** i **odkurzacz**. W pralce wpisujesz numer prania, a odkurzaczem możesz sterować przyciskiem **Włącz / Wyłącz**.


## ✨ Co robi aplikacja

- w sekcji **Pralka** pozwala wpisać **numer prania od 1 do 12** i zatwierdzić go przyciskiem,
- sprawdza, czy wpisana wartość jest poprawna – jeśli nie, pokazuje komunikat (`Toast`),
- w sekcji **Odkurzacz** przycisk **włącza i wyłącza** urządzenie, a napis obok pokazuje jego aktualny stan,
- każde urządzenie ma swoje zdjęcie.

Aplikacja ma jasnoniebieskie tło, nagłówek „urządzenie domowe” i podpis autora (*Autor: Patryk S*).

---


## 🔍 Jak działa aplikacja

### 1. Wygląd ekranu – `activity_main.xml`
Cały ekran to jeden pionowy `LinearLayout`. W środku są dwa poziome `LinearLayout` – w każdym po lewej stoi zdjęcie (`ImageView`), a po prawej kolumna z opisem, przyciskiem i tekstem.

Ważne elementy mają `id`, dzięki któremu można się do nich odwołać w Javie:

```xml
<EditText
    android:id="@+id/etNrPrania"
    android:hint="Podaj nr prania 1..12"
    android:inputType="number" />

<Button
    android:id="@+id/btnZatwierdz"
    android:text="Zatwierdź" />

<TextView
    android:id="@+id/tvWynikPralka"
    android:text="Numer prania: nie podano" />
```

- `inputType="number"` – na klawiaturze pokażą się tylko cyfry,
- `hint` – szara podpowiedź w pustym polu.

### 2. Podpięcie elementów – `MainActivity.java`
W metodzie `onCreate` łączę elementy z XML-a ze zmiennymi w Javie przez `findViewById`:

```java
etNrPrania = findViewById(R.id.etNrPrania);
btnZatwierdz = findViewById(R.id.btnZatwierdz);
tvWynikPralka = findViewById(R.id.tvWynikPralka);

btnOdkurzacz = findViewById(R.id.btnOdkurzacz);
tvStanOdkurzacza = findViewById(R.id.tvStanOdkurzacza);
```

### 3. Pralka – sprawdzanie numeru prania
Po kliknięciu **Zatwierdź** program robi trzy sprawdzenia:

```java
String tekst = etNrPrania.getText().toString().trim();

if (tekst.isEmpty()) {
    // pole puste -> Toast "Podaj numer prania od 1 do 12"
    return;
}

try {
    int numerPrania = Integer.parseInt(tekst);

    if (numerPrania >= 1 && numerPrania <= 12) {
        tvWynikPralka.setText("Numer prania: " + numerPrania);
    } else {
        // liczba spoza zakresu -> Toast "Numer prania musi być od 1 do 12"
    }
} catch (NumberFormatException e) {
    // to nie jest liczba -> Toast "Podaj poprawną liczbę"
}
```

- `trim()` – usuwa spacje z początku i końca tekstu,
- `Integer.parseInt` – zamienia tekst na liczbę,
- `try / catch` – łapie błąd, gdy tekstu nie da się zamienić na liczbę,
- `Toast` – mały komunikat, który sam znika po chwili.

### 4. Odkurzacz – przełącznik Włącz / Wyłącz
Zmienna `odkurzaczWlaczony` (typu `boolean`) pamięta, czy odkurzacz jest włączony. Każde kliknięcie **odwraca** jej wartość i zmienia napisy:

```java
btnOdkurzacz.setOnClickListener(v -> {
    if (!odkurzaczWlaczony) {
        odkurzaczWlaczony = true;
        btnOdkurzacz.setText("Wyłącz");
        tvStanOdkurzacza.setText("Odkurzacz włączony");
    } else {
        odkurzaczWlaczony = false;
        btnOdkurzacz.setText("Włącz");
        tvStanOdkurzacza.setText("Odkurzacz wyłączony");
    }
});
```

## 📚 Co jest zawarte w projekcie

- jak zbudować ekran z `LinearLayout`, `ImageView`, `EditText`, `Button` i `TextView`,
- jak połączyć elementy z XML-a z kodem Javy (`findViewById`),
- jak obsłużyć kliknięcie przycisku (`setOnClickListener`),
- jak sprawdzić dane od użytkownika (pusty tekst, zakres, błędny format),
- jak użyć `try / catch` i pokazać komunikat `Toast`,
- jak zapamiętać stan w zmiennej `boolean` i przełączać go przyciskiem.

---
