const cities = ["New-York", "Paris", "Tokyo", "London"];
for (const [i, city] of cities.entries()) {
    if (city === "Paris") {
        console.log(city + " est en position " + i)
    }
}

cities.forEach((val, i) => {
    if (val === "Paris") {
        console.log(val + " est en position " + i)
    }
})