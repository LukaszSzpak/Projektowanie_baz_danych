import * as React from 'react';
import { cloneElement, useMemo } from 'react';
import PropTypes from 'prop-types';
import {List, 
    Datagrid, 
    TextField, 
    EditButton, 
    DeleteButton,
    useListContext,
    TopToolbar,
    sanitizeListRestProps,
    CreateButton,
    } from 'react-admin'

const UserList = () => (props) => {
    return(
        <List {...props} title="Users" actions={ListActions}>
            <Datagrid>
                <TextField source='id'/>
                <TextField source='name'/>
                <TextField source='surname'/>
                <TextField source='email'/>
                <EditButton basePath='/user'/>
                <DeleteButton basePath='/user' />
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
        </TopToolbar>
    );
};

export default UserList