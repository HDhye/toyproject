
export interface Board {
    bulletinCode: number;
    title: string;
    views: number;
    content: string;
    creationDate: string;
    deleteYn: string;
    modifiedDate: string;
    allowComments: string;
    category: Category;
    employee: Employee;
}

export interface Category {
    categoryCode: number;
    nameBoard: string;
}

export interface Employee {
    empNo: number;
    empName: string;
}

interface BoardListRes {
    board: Board[];
    selectCriteria: Criteria;
}

export interface Criteria {
    currentPageNo: number;
    categoryCode: number;
    totalCount?: number;
    limit?: number;
    buttonAmount: number;
    maxPageNo: number;
    startPageNo: number;
    endPageNo: number;
    startRow?: number;
    endRow?: number;
    searchCondition?: string;
    searchValue?: string;
}




