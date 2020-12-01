import * as React from "react";
import { cloneElement, useMemo, } from 'react';

import { 
    List,
    Datagrid,
    TextField,
    NumberField,
    useListContext,
    ExportButton,
    TopToolbar,
    sanitizeListRestProps,
    BooleanField,
    Filter,
    TextInput,
    DateField,
    DeleteButton
} from 'react-admin';

import {Grid, Button} from '@material-ui/core'
import PropTypes from 'prop-types';
import { Fragment, useState } from 'react';


const TransactionList = (props) => (
    <List {...props}>
        <Datagrid>
            <NumberField source="id" />
            <TextField source="userId" />
            <TextField source="employeeId" />
            <TextField source="bookId" />
            <TextField sourde="rentDate" />
            <TextField sourde="datePlanningReturn" />
            <NumberField source="daysAfterReturnDate" />
            <NumberField source="additionalCost" />
            <BooleanField source="isBack" />
        </Datagrid>
    </List>
);

export default TransactionList