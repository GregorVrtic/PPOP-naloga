Vue.createApp({
    data() {
        return {
            oseba: {
                oid: 0,
                ime: "",
                priimek: "",
                tel: 0,
                email: "",
                poklic: ""
            },

            osebe: [],
        }
    },
        
    methods: {
        onInputName(e) {
            this.oseba.ime = e.target.value
        },

        onInputSurname(e) {
            this.oseba.priimek = e.target.value
        },

        onInputTel(e) {
            this.oseba.tel = e.target.value
        },

        onInputEmail(e) {
            this.oseba.email = e.target.value
        },

        onInputPoklic(e) {
            this.oseba.poklic = e.target.value
        },

        writeOsebaToConsole() {
            console.log(this.oseba)
        },

        addOseba() {
            axios
            .post("http://localhost:8080/osebe/createOseba", this.oseba)
            .then(response => {
                console.log(response)
                this.getAllOsebe()
            } )
            .catch(function (error) {
                console.log(error)
                alert("An ERROR HAS OCCURED Create OSEBA");
        })
        
        },

        deleteOseba(cid) {
            axios
            .delete("http://localhost:8080/osebe/deleteOseba/"+ cid)
            .then(response => {
                console.log(response)
                this.getAllOsebe()
            })
            .catch(function(error) {
                console.log(error)
                alert("An ERROR HAS OCCURED IN deletOseba")
            })
            
         },

         populateRow(c) {
             this.oseba = JSON.parse(JSON.stringify(c));
         },

         updateOseba() {
             axios
             .put("http://localhost:8080/osebe/updateOseba", this.oseba )
             .then(response => {console.log(response)
             this.getAllOsebe() })
             .catch(function (error) {
                 console.log(err, err.response);
                 alert("AN ERROR HAS OCCURED IN updateOseba")
             })
          
         },

        getAllOsebe() {
        axios
            .get ('http://localhost:8080/osebe/getAllOsebe')
            .then(response => this.osebe = response.data)
            .catch(function (error) {
                console.log(error)
                alert("Prišlo je do napake getAllOsebe Metoda")
        })             
        
        }
    },

    mounted: function () {
        axios
        .get ('http://localhost:8080/osebe/getAllOsebe')
        .then(response => this.osebe = response.data)
        .catch(function (error) {
            console.log(error)
            alert("Prišlo je do napake getAllOsebe Mounted")
        })
    }
    
}).mount("#oseba")