import './App.css';
import { Button } from '@material-ui/core';
import { DataGrid } from '@material-ui/data-grid';
import React from 'react';

class itemTable extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      items: []
    };
  }

  componentDidCatch() {
    fetch("localhost:5000/feed")
      .then(res => res.json())
      .then(
        (result) => {
          this.setState({
            isLoaded: true,
            items: result.items
          })
        },

        (error) => {
          this.setState({
            isLoaded: true,
            error
          })
        }
      )
  }

  render() {
    const { error, isLoaded, items } = this.state;
    if (error) {
      return <div>Error</div>
    } else if (!isLoaded) {
      return <div>Not Loaded</div>
    } else {
      return (
        <ul>
          {items.map(item => (
            <li key={item.username}>
              {item.password}
            </li>
          ))}
        </ul>
      )
    }
  }
}

function App() {
  return (
    <div className="App">
      <header className="App-header">
       <Button color="primary">State of Affairs</Button>
      </header>
    </div>
  );
}

export default App;
