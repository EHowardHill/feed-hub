import {Button} from '@material-ui/core';
import {DataGrid} from '@material-ui/data-grid';
import React from 'react';
import axios from 'axios';

class FeedListing extends React.Component {
  state = {
    persons: []
  }

  componentDidMount() {
    axios.get(`/feed`)
      .then(res => {
        const persons = res.data;
        this.setState({ persons });
      })
  }

  render() {
    var row = [
      {"name": "BIG", "price": "YES"}
    ]
    var column = [
      {field: 'name', headerName: "Name"},
      {field: 'price', headerName:"Price"}
    ];
    return (
      <ul>
        { this.state.persons.map(person => (
          <div><li>{person.name}</li><li>{person.price}
          </li></div>
        ))}
      </ul>
    )
  }
}

function App() {
  return (
    <div className="App">
      <header className="App-header">
       <Button color="primary">State of Affairs</Button>
       <FeedListing></FeedListing>
      </header>
    </div>
  );
}

export default App;
