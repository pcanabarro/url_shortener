const express = require("express")
const router = express.Router()

module.exports = class Router {
  static getRouter() {
    router.get("/", (req, res) => {res.send("First test")})

    return router
  }
}
