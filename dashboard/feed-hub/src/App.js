import {Button} from '@material-ui/core';
import {Grid} from '@material-ui/core';
import {TextField} from '@material-ui/core';
import {Card} from '@material-ui/core';
import {DataGrid} from '@material-ui/data-grid';
import {Alert, AlertTitle} from '@material-ui/lab';
import React from 'react';
import axios from 'axios';
import './App.css'
import Dashboard from './Dashboard.js'

class FeedListing extends React.Component {
  state = {
    persons: [],
    rows: [],
    columns: []
  }

  componentDidMount() {
    axios.get(`/feed`)
      .then(res => {
        const persons = res.data;
        
        this.setState(
          {
            persons: persons,
            columns: [
              { field: 'id', headerName: 'ID', width: 72 },
              { field: 'name', headerName: 'Name', width: 140},
              { field: 'price', headerName: 'Price'}
            ],
            rows: res.data
          }
        );
      })
  }

  render() {
    return (
      <div style={{ height: 400, width: '100%' }}>
        <DataGrid checkboxSelection rows={this.state.rows} columns={this.state.columns} pageSize={5} checkboxSelection />
      </div>
    )
  }
}

class ErrorMessage extends React.Component {
  render() {
    switch(this.props.error) {
      case 'null':
        return(<div></div>)
      case 'dne':
        return(
          <Alert severity="error">
            <AlertTitle>Account Does Not Exist</AlertTitle>
            Please try a different username or create an account
          </Alert>
        )
      case 'fail':
        return(
          <Alert severity="error">
            <AlertTitle>Incorrect Password</AlertTitle>
            Please try again
          </Alert>
        )
      case 'pass':
        return(<div>Success!</div>)
    }
  }
}

class Landing extends React.Component {
  state = {
    page: 0, // Sign-in,
    error: 'null'
  }

  signIn = () => {
    const formData  = new FormData();

    var sendData = {
      username: document.getElementById('username').value,
      password: document.getElementById('password').value
    };

    for(const name in sendData) {
      formData.append(name, sendData[name]);
    }

    fetch('/login', {method: 'post', body: formData})
      .then(response => response.text())
      .then(
        data => this.setState({error: data})
        );
  }

  render() {
    switch (this.state.page) {
      case 0:
        return (
          <div className="App">

          <Grid
            container
            spacing={0}
            direction="column"
            alignItems="center"
            justify="center"
            style={{ minHeight: '100vh' }}
          >

            <Grid item xs={3}>
              <Card>
                <form className="Pleasant" noValidate autoComplete="on">
                  <TextField fullWidth id="username" label="Email Address"/>
                  <TextField fullWidth id="password" label="Password" type="password"/>
                </form>
                <Button fullWidth>New Account</Button>
                <Button fullWidth>Forgot Password</Button>
                <Button fullWidth onClick={this.signIn} color="primary">Log In</Button>
                <ErrorMessage error={this.state.error}></ErrorMessage>
              </Card>
            </Grid>   

          </Grid>
          </div>
        )

      case 1:
        return (
          <div>
          <header className="App-header">
           <Button color="primary">State of Affairs</Button>
           <FeedListing></FeedListing>
          </header>
        </div>
        )
    
      default:
        return (
          <div className="App">
            No Page Found
          </div>
        )
    }
  }
}

class App extends React.Component {
  state = {
    page: 'dashboard'
  }

  render() {
    switch(this.state.page) {
      case 'login':
        return (
          <Landing />
        )
      case 'dashboard':
        return (
          <Dashboard />
        )
      default:
        return(<div></div>)
    }
  }

}

export default App;
