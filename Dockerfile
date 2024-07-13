FROM node:21
WORKDIR /usr/src/app
COPY package*.json ./
RUN npm install
COPY . .
EXPOSE 3001
USER node
CMD ["npm", "start"]