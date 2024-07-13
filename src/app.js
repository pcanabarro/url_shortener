const cors = require('cors')
const dotenv = require("dotenv")
const express = require("express")
const router = require("./routes/router")

dotenv.config()

class App {
  constructor() {
    this.app = express()
    this.port = process.env.SERVER_PORT

    this.app.use(cors())
    this.app.use(express.json())
    this.app.use(router.getRouter())
  }

  start() {
    this.app.listen(this.port, () => {
      console.log(`Server running at ${this.port} port`)
    })
  }
}

module.exports = new App().start()
