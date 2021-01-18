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


const GuestBookList = (props) => (
    <List {...props} filters = {<BookFilter />}>
        <Datagrid>
            <NumberField source="id" />
            <TextField source="title" />
            <TextField source="author" />
            <TextField source="description" />
            <BooleanField source="available" />
        </Datagrid>
    </List>
);

const BookFilter = (props) => (
    <Filter {...props}>
        <TextInput label="Search" source="q" alwaysOn />
        <TextInput label="Title" source="title" defaultValue="Hello, World!" />
    </Filter>
);

export default GuestBookList