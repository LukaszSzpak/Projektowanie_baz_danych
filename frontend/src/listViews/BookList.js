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
    TextInput 
} from 'react-admin';

import {Grid, Button} from '@material-ui/core'
import PropTypes from 'prop-types';
import { Fragment, useState } from 'react';
import AddToWishList from '../customButtons/AddToWishList'


const BookList = (props) => (
    <List {...props} bulkActionButtons = {<BookBulkActionButtons/>} filters = {<BookFilter />}>
        <Datagrid>
            <NumberField source="id" />
            <TextField source="title" />
            <TextField source="author" />
            <TextField source="description" />
            <BooleanField source="available" />
        </Datagrid>
    </List>
);

const BookBulkActionButtons = props => (
    <Fragment>
        <AddToWishList label="Add to wish list" {...props} />
    </Fragment>
);

const BookFilter = (props) => (
    <Filter {...props}>
        <TextInput label="Search" source="q" alwaysOn />
        <TextInput label="Title" source="title" defaultValue="Hello, World!" />
    </Filter>
);

export default BookList