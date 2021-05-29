import React from 'react';
import './App.css'

import AppBar from "@material-ui/core/AppBar";
import Tabs from "@material-ui/core/Tabs";
import Tab from "@material-ui/core/Tab";
import Box from "@material-ui/core/Box";

import { makeStyles } from '@material-ui/core/styles';
import Accordion from '@material-ui/core/Accordion';
import AccordionSummary from '@material-ui/core/AccordionSummary';
import AccordionDetails from '@material-ui/core/AccordionDetails';
import Typography from '@material-ui/core/Typography';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';

import Chip from '@material-ui/core/Chip';

import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import { AlertTitle } from '@material-ui/lab';

function TabPanel(props) {
    const { children, value, index, ...other } = props;
    return (
      <div {...other}>
        {value === index && <Box p={3}>{children}</Box>}
      </div>
    );
}

const DenseTableStyle = makeStyles({
    table: {
      minWidth: 650,
    },
});

class DenseTable extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            rows: this.props.rows
        }
    }

    render() {
        return (
            <TableContainer component={Paper}>
                <Table className={DenseTableStyle.table} size="small" aria-label="a dense table">
                <TableHead>
                    <TableRow>
                    <TableCell>Name</TableCell>
                    <TableCell align="right">Price</TableCell>
                    <TableCell align="right">Quantity</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {Object.entries(this.state.rows).map(([key,row]) => (
                    <TableRow>
                        <TableCell component="th" scope="row">{row.name}</TableCell>
                        <TableCell component="th" scope="row">{row.price}</TableCell>
                        <TableCell component="th" scope="row">{row.quantity}</TableCell>
                    </TableRow>
                    ))}
                </TableBody>
                </Table>
            </TableContainer>
            );
    }
}

class SimpleAccordian extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            information: {},
            isLoaded: false
        }
      }

    componentDidMount() {
        const formData  = new FormData();
    
        var sendData = {};
    
        for(const name in sendData) {
          formData.append(name, sendData[name]);
        }
    
        fetch('/feed', {method: 'post', body: formData})
          .then(response => response.json())
          .then(data => this.setState({
              information: data,
              isLoaded: true
          }));
    }

    render () {

        if (this.state.isLoaded) {
            return(
                <div>{
                    Object.entries(this.state.information).map(([key,value]) => {
                        return(
                            <Accordion>
                                <AccordionSummary
                                    expandIcon={<ExpandMoreIcon />}
                                    aria-controls="panel2a-content"
                                    id="panel2a-header"
                                >
                                    <Typography>{value.location}</Typography>
                                </AccordionSummary>
                                <AccordionDetails>
                                    <Typography>
                                    <Chip style={{margin: 12}}
                                    label="Unit #12"
                                    />
                                    <DenseTable rows={value.items} />
                                    </Typography>
                                </AccordionDetails>
                            </Accordion>
                        )
                    })
                }</div>
            )
        } else {
            return (
                <div></div>
            )
        }
    }
}

class DeploymentGrid extends React.Component {
    constructor(props) {
      super(props);
      this.state = {}
    }

    componentDidMount() {
        const formData  = new FormData();
    
        var sendData = {};
    
        for(const name in sendData) {
          formData.append(name, sendData[name]);
        }
    
        fetch('/feed', {method: 'post', body: formData})
          .then(response => response.text())
          .then(data => alert("Loaded!"));
    }
}

class Dashboard extends React.Component {
state = {
    value: 0
}

render () {
    const handleChange = (event, newValue) => {
    this.setState({
        value: newValue
    });
    };
    return (
    <div>
        <AppBar position="static">
        <Tabs
            value={this.state.value}
            onChange={handleChange}
            centered>
            <Tab label="Deployments" />
            <Tab label="Inventory" />
            <Tab label="Cade Simpson" />
        </Tabs>
        </AppBar>
        <TabPanel value={this.state.value} index={0}>
        <SimpleAccordian></SimpleAccordian>
        </TabPanel>
        <TabPanel value={this.state.value} index={1}>
        Item Two
        </TabPanel>
        <TabPanel value={this.state.value} index={2}>
        Item Three
        </TabPanel>
    </div>
    );
}
}

export default Dashboard;