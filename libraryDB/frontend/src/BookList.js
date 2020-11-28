import * as React from 'react';
import { cloneElement, useMemo } from 'react';
import PropTypes from 'prop-types';
import {List, 
    Datagrid, 
    TextField, 
    EditButton, 
    DeleteButton,
    useListContext,
    BooleanField, 
    } from 'react-admin'

export default function UserList(props) {
    return(
        <List {...props} title="Accounts" actions={ListActions}>
            <Datagrid>
                <TextField source='id'/>
                <TextField source='name'/>
                <TextField source='surname'/>
                <TextField source='email'/>
                <BooleanField source='role'/>
                <EditButton basePath='/account'/>
                <DeleteButton basePath='/account' />
            </Datagrid>
        </List>
    );
}


const ListActions = (props) => {
    const {
        className,
        exporter,
        filters,
        maxResults,
        ...rest
    } = props;
    const {
        currentSort,
        resource,
        displayedFilters,
        filterValues,
        hasCreate,
        basePath,
        selectedIds,
        showFilter,
        total,
    } = useListContext();
    return (
        <TopToolbar className={className} {...sanitizeListRestProps(rest)}>
            {filters && cloneElement(filters, {
                resource,
                showFilter,
                displayedFilters,
                filterValues,
                context: 'button',
            })}
            <CreateButton basePath={basePath} />
            <EditButton basePath={basePath} />
            <DeleteButton basePath={basePath} />
                <IconEvent />
        </TopToolbar>
    );
};