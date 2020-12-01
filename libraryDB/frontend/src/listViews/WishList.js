import * as React from "react";
import { cloneElement, useMemo } from 'react';
import { List,
    Datagrid,
    TextField,
    NumberField,
    BooleanField,
    ExportButton,
    CreateButton,
    DeleteButton
} from 'react-admin';
import {Grid, Button} from '@material-ui/core'
import PropTypes from 'prop-types';


export const WishList = (props) => (
    <List {...props}>
        <Datagrid>
            <NumberField source="id" />
            <TextField source="title" />
            <TextField source="author" />
            <TextField source="description" />
            <BooleanField source="avalible" />
            <ExportButton></ExportButton>
            <DeleteButton></DeleteButton>
        </Datagrid>
    </List>
);

export default WishList