<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Thank you!!!</title>
    <link rel="stylesheet" href="/css/candidates.css">
</head>

<body>
    <div class="container flex flex-col align-center">
      <h1>${person.name} thanks you for your vote!</h1>
      <main class="flex flex-wrap align-center">
        <div class="card flex flex-col align-center">
          <img src="/images/${person.photo}">
          <p>Thank you for your vote!</p>
          <p>Now I have ${votes}% of all votes</p>
        </div>
      </main>
      <p>-------------------------------------------------------</p>
      <a class="back flex align-center" href="/votes">Show total votes</a>
      <p>-------------------------------------------------------</p>
      <a class="back flex align-center" href="/">back to main</a>
    </div>
</body>

</html>