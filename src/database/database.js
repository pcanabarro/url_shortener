const pg = require("pg")

module.exports = new class Database {
  constructor() {
    this.DB_PORT = process.env.DB_PORT
    this.DB_HOST = process.env.DB_HOST
    this.DB_NAME = process.env.DB_NAME
    this.DB_USER = process.env.DB_USER
    this.DB_PASSWORD = process.env.DB_PASSWORD
    this.DB_MIN_CONNECTIONS = process.env.DB_MIN_CONNECTIONS
    this.DB_MAX_CONNECTIONS = process.env.DB_MAX_CONNECTIONS
    this.DB_IDLE_TIMEOUT =process.enV.DB_IDLE_TIMEOUT

  }

  query() {

  }

  createTables() {
    // Create tables if don't exist
  }
}