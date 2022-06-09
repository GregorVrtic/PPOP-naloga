Vue.createApp({
    data() {
        return {
            oglas: {
                ogid: 0,
                naslov: "",
                vsebina: "",
                oseba: {}
            },

            oglasi: [], /*rabimo za shranjevanje podatkov iz DB z uporabo metode mount! */
            oseba: []
         }
     },
    
    methods: {
        onInputeName(e) {
            this.oglas.vsebina=e.target.value
        },

        writeOglasToConsole() {
            console.log(this.oglas)
        },

        populateRow(c){
            this.oglas = JSON.parse(JSON.stringify(c));
        },

        readOglas() {
            axios
            .get("http://localhost:8080/oglasi/getAllOglasi")
            .then(response => (this.oglasi = response.data))
            .catch(function (error) {
                console.log(error);
            });
        },

        readOseba() {
            axios
            .get("http://localhost:8080/osebe/getAllOsebe")
            .then(response => (this.oseba = response.data))
            .catch(function (error) {
                console.log(error);
            });
        },

        createOglas() {
            axios
            .post("http://localhost:8080/oglasi/createOglas", this.oglas)
            .catch(function (error) {
                console.log(error);
            });
        },

        
                
        

    },

    mounted: function () {
        axios
        .get ('http://localhost:8080/oglasi/getAllOglasi')
        .then(response => (this.oglasi = response.data))
        .catch(function (error) {
            console.log(error);
        });

        axios
        .get ('http://localhost:8080/osebe/getAllOsebe')
        .then(response => (this.oseba = response.data))
        .catch(function (error) {
            console.log(error);
        });
    }

}).mount("#oglas")