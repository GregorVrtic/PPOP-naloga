Vue.createApp({
    data() {
        return {
            delodajalec: {
                did: 0,
                imeDruzbe: "",
                kraj: "",
                opis: "",
                delovnoMesto: "",
                izobrazba: "",
                mail: "",
                mobi: 0,
                ura: 0.0
            },

            delodajalci: [],
            kraj : []
        }
    },
        
    methods: {
        onInputImeDruzbe(e) {
            this.delodajalec.imeDruzbe = e.target.value
        },

        onInputKraj(e) {
            this.delodajalec.kraj = e.target.value
        },

        onInputDelovnoMesto(e) {
            this.delodajalec.delovnoMesto = e.target.value
        },

        onInputEmail(e) {
            this.delodajalec.mail = e.target.value
        },

        onInputPlacilo(e) {
            this.delodajalec.ura = e.target.value
        },

        writeDelodajalecToConsole() {
            console.log(this.delodajalec)
        },

        createDelodajalec() {
            axios
            .post("http://localhost:8080/delodajalec/createDelodajalec", this.delodajalec)
            .then(response => {
                console.log(response)
                this.getAllDelodajalci()
            } )
            .catch(function (error) {
                console.log(error)
                alert("An ERROR HAS OCCURED Create Delodajalec");
        })
        },

        getByKraj() {
            axios
            .get("http://localhost:8080/", this.kraj)
            .then(response => {
                console.log(response)
                this.getByKraj()
            } )
            .catch(function (error) {
                console.log(error)
                alert("An ERROR HAS OCCURED Create GetByKraj");
            })
        },

        
        deleteDelodajalec(did) {
            axios
            .delete("http://localhost:8080/delodajalec/deleteDelodajalec/"+ did)
            .then(response => {
                console.log(response)
                this.getAllDelodajalci()
            })
            .catch(function(error) {
                console.log(error)
                alert("An ERROR HAS OCCURED IN deletDelodajalec")
            })
            
         },

         populateRow(c) {
             this.delodajalec = JSON.parse(JSON.stringify(c));
         },

         updateDelodajalec() {
             axios
             .put("http://localhost:8080/delodajalec/updateDelodajalec", this.delodajalec )
             .then(response => {console.log(response)
             this.getAllDelodajalci() })
             .catch(function (error) {
                 console.log(err, err.response);
                 alert("AN ERROR HAS OCCURED IN updateDelodajalec")
             })
          
         },

        getAllDelodajalci() {
        axios
            .get ('http://localhost:8080/delodajalec/getAllDelodajalci')
            .then(response => this.delodajalci = response.data)
            .catch(function (error) {
                console.log(error)
                alert("Prišlo je do napake getAllDelodajalci Metoda")
        })             
        
        }
    },

    mounted: function () {
        axios
        .get ('http://localhost:8080/delodajalec/getAllDelodajalci')
        .then(response => this.delodajalci = response.data)
        .catch(function (error) {
            console.log(error)
            alert("Prišlo je do napake getAllDelodajalci Mounted")
        })
    }
    
}).mount("#delo")