import {Button} from '@material-ui/core';
import {Grid} from '@material-ui/core';
import {TextField} from '@material-ui/core';
import {Card, CardActions, CardContent} from '@material-ui/core';
import {DataGrid} from '@material-ui/data-grid';
import React from 'react';
import axios from 'axios';
import './App.css'

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

class Landing extends React.Component {
  state = {
    page: 0 // Sign-in
  }

  signIn() {
    var user = document.getElementById('username').value;
    var pass = document.getElementById('password').value;
    alert(user);
  }

  render() {
    switch (this.state.page) {
      case 0:
        return (
          <div className="App">
          <Grid container direction="row" justify="space-between" alignItems="center">
            <div>
              
            </div>
            <div>
            <Card>
              <form className="Pleasant" noValidate autoComplete="on">
                <TextField id="username" label="Email Address"/>
                <TextField id="password" label="Password" type="password"/>
              </form>
              <Grid container direction="row" justify="space-between" alignItems="center">
                <Button>New Account</Button>
                <Button onClick={this.signIn} color="primary">Log In</Button>
                <Button>Forgot Password</Button>
              </Grid>
            </Card>
            </div>
            <div>
              
            </div>
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

function App() {
  return (
    <Landing />
  );
}

export default App;
