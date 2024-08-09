# URL Shortening Service

## How to Create a URL

To create a new URL, send a `POST` request to the following endpoint:

- **Endpoint:** `POST http://localhost:8080/api/url/`
- **Request Body:** JSON object containing URL details.
    - **Example:**

      ```json
      {
        "originalUrl": "https://github.com/pcanabarro/"
      }
      ```

- **Response:** A message with the generated shortcut URL.
    - **Example Response:**
      ```text
      URL created, your shortcut is http://localhost:8080/git
      ```

## How to See Your URL

To retrieve details of a URLs, send a `GET` request to:

- **Endpoint:** `GET http://localhost:8080/api/url/all`
- **Response:** JSON object with URLs details.
    - **Example Response:**
      ```json
      {
        "id": 1,
        "originalUrl": "https://github.com/pcanabarro/",
        "shortUrl": "git"
      }
      ```

## How to Access the Endpoint to Be Redirected

To be redirected to the original URL from a short URL, send a `GET` request to:

- **Endpoint:** `GET http://localhost:8080/{shortcut}`
- **Path Variable:** `shortcut` (e.g., `git`)

- **Response:** A redirect to the original URL. If the shortcut is valid, you will be redirected to the original URL associated with it. If not, you will receive a `404 Not Found` error.
