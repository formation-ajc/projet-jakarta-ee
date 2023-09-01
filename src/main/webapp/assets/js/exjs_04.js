const cities = ["New-York", "Paris", "Tokyo", "London"];

const action = (val, i) => {
    console.log(val + " est en position " + i)
}

const recherche = (tab, elem, callback) => {
    tab.forEach((val, i) => {
        if (val === elem) {
            callback(val, i)
        }
    })
}

recherche(cities, "Paris", action);


